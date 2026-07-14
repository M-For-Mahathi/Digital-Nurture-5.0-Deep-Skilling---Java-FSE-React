import React, { Component } from "react";

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      email: "",
      password: "",
      errors: {}
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  handleSubmit(event) {
    event.preventDefault();
    const errors = {};

    if (this.state.name.length < 5) {
      errors.name = "Name should have atleast 5 characters";
    }
    if (!this.state.email.includes("@") || !this.state.email.includes(".")) {
      errors.email = "Email should have @ and .";
    }
    if (this.state.password.length < 8) {
      errors.password = "Password should have atleast 8 characters";
    }

    this.setState({ errors: errors });
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <input type="text" name="name" value={this.state.name} onChange={this.handleChange} />
        {this.state.errors.name && <p>{this.state.errors.name}</p>}

        <input type="text" name="email" value={this.state.email} onChange={this.handleChange} />
        {this.state.errors.email && <p>{this.state.errors.email}</p>}

        <input type="password" name="password" value={this.state.password} onChange={this.handleChange} />
        {this.state.errors.password && <p>{this.state.errors.password}</p>}

        <button type="submit">Register</button>
      </form>
    );
  }
}

export default Register;
