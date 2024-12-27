CREATE TABLE IF NOT EXISTS "Users"
(
    "id"       SERIAL                                                         NOT NULL PRIMARY KEY,
    "login"    VARCHAR(50)                                                    NOT NULL UNIQUE,
    "password" VARCHAR(60)                                                    NOT NULL,
    "email"    VARCHAR(50)                                                    NOT NULL,
    "weight"   DOUBLE PRECISION                                               NOT NULL,
    "height"   DOUBLE PRECISION                                               NOT NULL,
    "gender"   VARCHAR(1) CHECK ("gender" IN ('M', 'F'))                      NOT NULL,
    "purpose"  VARCHAR(255) CHECK ("purpose" IN ('lose', 'maintain', 'gain')) NOT NULL,
    "role"  VARCHAR(255) CHECK ("role" IN ('Admin', 'User')) NOT NULL
);

CREATE TABLE IF NOT EXISTS "DayProgress"
(
    "id"             SERIAL  NOT NULL PRIMARY KEY,
    "id_User"        INTEGER NOT NULL,
    "recording_date" DATE    NOT NULL,
    FOREIGN KEY ("id_User") REFERENCES "Users" ("id")
);

CREATE INDEX IF NOT EXISTS idx_dayprogress_user_date ON "DayProgress" ("id_User", "recording_date");

CREATE TABLE IF NOT EXISTS "Product"
(
    "id"            SERIAL        NOT NULL PRIMARY KEY,
    "name"          VARCHAR(60)   NOT NULL,
    "calories"      BIGINT        NOT NULL CHECK ("calories" >= 0),
    "proteins"      DECIMAL(8, 2) NOT NULL CHECK ("proteins" >= 0),
    "fats"          DECIMAL(8, 2) NOT NULL CHECK ("fats" >= 0),
    "carbohydrates" DECIMAL(8, 2) NOT NULL CHECK ("carbohydrates" >= 0)
);

CREATE TABLE IF NOT EXISTS "DayProgress_product"
(
    PRIMARY KEY ("id_DayProgress", "id_Product"),
    "id_DayProgress"   INTEGER                                                         NOT NULL,
    "id_Product"       INTEGER                                                         NOT NULL,
    "grams_of_product" DECIMAL(8, 2)                                                   NOT NULL,
    "meal"             VARCHAR(255) CHECK ("meal" IN ('breakfast', 'lunch', 'dinner')) NOT NULL,
    FOREIGN KEY ("id_DayProgress") REFERENCES "DayProgress" ("id"),
    FOREIGN KEY ("id_Product") REFERENCES "Product" ("id")
);

CREATE TABLE IF NOT EXISTS "Exercises"
(
    "id"                SERIAL                                                          NOT NULL PRIMARY KEY,
    "Name"              VARCHAR(60)                                                     NOT NULL,
    "calories_per_hour" BIGINT                                                          NOT NULL,
    "intensity"         VARCHAR(255) CHECK ("intensity" IN ('light', 'medium', 'hard')) NOT NULL
);

CREATE TABLE IF NOT EXISTS "DayProgress_Exercises"
(
    "id_DayProgress"     INTEGER                   NOT NULL,
    "id_Exercises"   INTEGER                   NOT NULL,
    "execution_time" TIME(0) WITHOUT TIME ZONE NOT NULL,
    FOREIGN KEY ("id_DayProgress") REFERENCES "DayProgress" ("id"),
    FOREIGN KEY ("id_Exercises") REFERENCES "Exercises" ("id")
);

-- Таблица для логов
CREATE TABLE IF NOT EXISTS "Logs"
(
    "id"        SERIAL PRIMARY KEY,
    "timestamp" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    "level"     VARCHAR(50) NOT NULL,
    "message"   TEXT NOT NULL,
    "context"   JSONB
);

CREATE OR REPLACE FUNCTION log_table_changes()
    RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'INSERT' THEN
        INSERT INTO "Logs" ("level", "message", "context")
        VALUES ('INFO', 'Row inserted into ' || TG_TABLE_NAME,
                jsonb_build_object('new_data', row_to_json(NEW)));
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO "Logs" ("level", "message", "context")
        VALUES ('INFO', 'Row updated in ' || TG_TABLE_NAME,
                jsonb_build_object('old_data', row_to_json(OLD), 'new_data', row_to_json(NEW)));
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO "Logs" ("level", "message", "context")
        VALUES ('INFO', 'Row deleted from ' || TG_TABLE_NAME,
                jsonb_build_object('old_data', row_to_json(OLD)));
    END IF;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER users_table_logger
    AFTER INSERT OR UPDATE OR DELETE
    ON "Users"
    FOR EACH ROW
EXECUTE FUNCTION log_table_changes();

CREATE TRIGGER dayprogress_table_logger
    AFTER INSERT OR UPDATE OR DELETE
    ON "DayProgress"
    FOR EACH ROW
EXECUTE FUNCTION log_table_changes();


CREATE TRIGGER Product_logger
    AFTER INSERT OR UPDATE OR DELETE
    ON "Product"
    FOR EACH ROW
EXECUTE FUNCTION log_table_changes();

CREATE TRIGGER DayProgress_Exercises_logger
    AFTER INSERT OR UPDATE OR DELETE
    ON "DayProgress_Exercises"
    FOR EACH ROW
EXECUTE FUNCTION log_table_changes();

CREATE TRIGGER DayProgress_logger
    AFTER INSERT OR UPDATE OR DELETE
    ON "DayProgress"
    FOR EACH ROW
EXECUTE FUNCTION log_table_changes();

-- DROP TABLE "DayProgress_Exercises";
-- DROP TABLE "DayProgress_product";
-- DROP TABLE "Product";
-- DROP table "Exercises";
-- DROP TABLE "DayProgress";
-- DROP TABLE "Users";

