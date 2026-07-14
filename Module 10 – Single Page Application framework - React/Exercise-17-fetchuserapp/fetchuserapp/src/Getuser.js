import React, { Component } from "react";

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = { user: null };
  }

  componentDidMount() {
    fetch("https://randomuser.me/api/")
      .then((response) => response.json())
      .then((data) => {
        this.setState({ user: data.results[0] });
      });
  }

  render() {
    if (!this.state.user) {
      return <p>Loading...</p>;
    }

    return (
      <div>
        <img src={this.state.user.picture.large} alt="user" />
        <p>{this.state.user.name.title}</p>
        <p>{this.state.user.name.first}</p>
      </div>
    );
  }
}

export default Getuser;
