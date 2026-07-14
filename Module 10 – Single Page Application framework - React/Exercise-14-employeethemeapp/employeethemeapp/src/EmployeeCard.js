import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard(props) {
  const theme = useContext(ThemeContext);

  return (
    <div>
      <p>{props.employee.name}</p>
      <button className={theme}>View</button>
    </div>
  );
}

export default EmployeeCard;
