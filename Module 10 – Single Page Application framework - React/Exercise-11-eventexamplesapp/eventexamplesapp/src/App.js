import React, { Component } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { count: 0, message: "" };
    this.handleIncrement = this.handleIncrement.bind(this);
    this.handleDecrement = this.handleDecrement.bind(this);
    this.handlePress = this.handlePress.bind(this);
  }

  incrementValue() {
    this.setState({ count: this.state.count + 1 });
  }

  sayHello() {
    this.setState({ message: "Hello" });
  }

  handleIncrement() {
    this.incrementValue();
    this.sayHello();
  }

  handleDecrement() {
    this.setState({ count: this.state.count - 1 });
  }

  sayWelcome(name) {
    alert(name);
  }

  handlePress(event) {
    alert("I was clicked");
  }

  render() {
    return (
      <div>
        <p>Count: {this.state.count}</p>
        <p>{this.state.message}</p>
        <button onClick={this.handleIncrement}>Increment</button>
        <button onClick={this.handleDecrement}>Decrement</button>

        <button onClick={() => this.sayWelcome("welcome")}>Say Welcome</button>

        <button onClick={this.handlePress}>Press</button>

        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
