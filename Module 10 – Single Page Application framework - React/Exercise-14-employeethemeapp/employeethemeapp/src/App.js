import React, { Component } from "react";
import ThemeContext from "./ThemeContext";
import EmployeesList from "./EmployeesList";

const employees = [
  { name: "Ravi Kumar" },
  { name: "Anjali Rao" },
  { name: "Suresh Babu" }
];

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { theme: "light" };
  }

  render() {
    return (
      <ThemeContext.Provider value={this.state.theme}>
        <div>
          <EmployeesList employees={employees} />
        </div>
      </ThemeContext.Provider>
    );
  }
}

export default App;
