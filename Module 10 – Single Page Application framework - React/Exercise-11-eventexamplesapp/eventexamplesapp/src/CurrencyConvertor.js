import React, { Component } from "react";

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = { rupees: "", euros: "" };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ rupees: event.target.value });
  }

  handleSubmit(event) {
    event.preventDefault();
    const euros = this.state.rupees * 0.011;
    this.setState({ euros: euros });
  }

  render() {
    return (
      <div>
        <input type="text" value={this.state.rupees} onChange={this.handleChange} />
        <button onClick={this.handleSubmit}>Convert</button>
        <p>Euros: {this.state.euros}</p>
      </div>
    );
  }
}

export default CurrencyConvertor;
