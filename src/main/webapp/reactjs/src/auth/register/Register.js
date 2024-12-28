import React from "react";
import {Button, FormGroup, Form} from "react-bootstrap";
import "./Register.css"
import apiClient from "../../axios_api/apiClient";
import {Link, Navigate} from "react-router";
import isTokenExpired from "../isTokenExpired";

class Register extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            login: "",
            email: "",
            password: "",
            weight: "",
            height: "",
            gender: "",
            purpose: ""
        }
        this.handleClick = this.handleClick.bind(this);
    }

    async handleClick() {
        try {
            const response = await apiClient.post("/api/v1/auth/register", {
                "login": this.state.login,
                'password': this.state.password,
                'email': this.state.email,
                'weight': this.state.weight,
                'height': this.state.height,
                'gender': this.state.gender,
                'purpose': this.state.purpose
            })
            localStorage.setItem("token", response.data.token);

            this.setState({greeting: `Добро пожаловать, ${this.state.user}`});
            window.location.href = "/hello-page";
        } catch (err) {
            console.log(err);
            this.setState({greeting: `Ошибка: ${err.message}`});
        }
    }

    render() {
        if (!isTokenExpired()) return <Navigate to="/hello-page"/>;
        return (
            <div>
                <h1 className="mx-auto d-flex flex-row justify-content-center mt-5">Регистрация</h1>
                <Form className="register-form">
                    <FormGroup>
                        <Form.Label htmlFor="login">login: </Form.Label>
                        <Form.Control type="text" id="login" placeholder="Иван"
                                      onChange={(event) => this.setState({login: event.target.value})}></Form.Control>
                    </FormGroup>
                    <FormGroup>
                        <Form.Label htmlFor="password">Password: </Form.Label>
                        <Form.Control type="password" id="password" placeholder="От 8 цифр"
                                      onChange={(event) => this.setState({password: event.target.value})}></Form.Control>
                    </FormGroup>
                    <FormGroup>
                        <Form.Label htmlFor="email">Email: </Form.Label>
                        <Form.Control type="email" id="email" placeholder="Ivanov@mail.ru"
                                      onChange={(event) => this.setState({email: event.target.value})}></Form.Control>
                    </FormGroup>
                    <FormGroup>
                        <Form.Label htmlFor="weight">Weight: </Form.Label>
                        <Form.Control type="weight" id="weight" placeholder="вес в кг"
                                      onChange={(event) => this.setState({weight: event.target.value})}></Form.Control>
                    </FormGroup>
                    <FormGroup>
                        <Form.Label htmlFor="height">Height: </Form.Label>
                        <Form.Control type="height" id="height" placeholder="рост в см"
                                      onChange={(event) => this.setState({height: event.target.value})}></Form.Control>
                    </FormGroup>
                    <FormGroup>
                        <Form.Label htmlFor="gender">Gender: </Form.Label>
                        <Form.Control
                            as="select"
                            id="gender"
                            onChange={(event) => this.setState({gender: event.target.value})}>
                            <option value="MALE">male</option>
                            <option value="FEMALE">female</option>
                        </Form.Control>
                    </FormGroup>
                    <FormGroup>
                        <Form.Label htmlFor="purpose">Purpose: </Form.Label>
                        <Form.Control
                            as="select"
                            id="purpose"
                            onChange={(event) => this.setState({purpose: event.target.value})}>
                            <option value="LOSE">lose</option>
                            <option value="MAINTAIN">maintain</option>
                            <option value="GAIN">gain</option>
                        </Form.Control>
                    </FormGroup>

                    <Button className="m-4" variant="outline-primary" onClick={this.handleClick}>Регистрация</Button>
                    <Link to="/login">
                        <Button variant="outline-secondary">Логин</Button>
                    </Link>
                </Form>

                <div className="text-center">{this.state.greeting}</div>
            </div>
        )
    }
}

export default Register;
