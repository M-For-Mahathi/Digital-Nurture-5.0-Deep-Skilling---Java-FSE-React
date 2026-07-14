import React, { Component } from "react";
import GitClient from "./GitClient";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { repositories: [] };
    this.gitClient = new GitClient();
  }

  componentDidMount() {
    this.gitClient.getRepositories("techiesyed").then((repositories) => {
      this.setState({ repositories: repositories });
    });
  }

  render() {
    return (
      <div>
        {this.state.repositories.map((name, index) => (
          <p key={index}>{name}</p>
        ))}
      </div>
    );
  }
}

export default App;
