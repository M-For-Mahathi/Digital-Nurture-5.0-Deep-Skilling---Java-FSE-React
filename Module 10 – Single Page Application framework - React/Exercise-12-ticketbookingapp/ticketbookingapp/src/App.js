import React, { Component } from "react";

function GuestPage() {
  return (
    <div>
      <h2>Flight Details</h2>
      <p>Hyderabad to Delhi - 4500</p>
      <p>Hyderabad to Mumbai - 3800</p>
    </div>
  );
}

function UserPage() {
  return (
    <div>
      <h2>Book Tickets</h2>
      <p>Hyderabad to Delhi - 4500 <button>Book</button></p>
      <p>Hyderabad to Mumbai - 3800 <button>Book</button></p>
    </div>
  );
}

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { isLoggedIn: false };
    this.handleLogin = this.handleLogin.bind(this);
    this.handleLogout = this.handleLogout.bind(this);
  }

  handleLogin() {
    this.setState({ isLoggedIn: true });
  }

  handleLogout() {
    this.setState({ isLoggedIn: false });
  }

  render() {
    return (
      <div>
        {this.state.isLoggedIn ? (
          <button onClick={this.handleLogout}>Logout</button>
        ) : (
          <button onClick={this.handleLogin}>Login</button>
        )}
        {this.state.isLoggedIn ? <UserPage /> : <GuestPage />}
      </div>
    );
  }
}

export default App;
