import React from "react";
import EmployeeCard from "./EmployeeCard";

function EmployeesList(props) {
  return (
    <div>
      {props.employees.map((employee, index) => (
        <EmployeeCard key={index} employee={employee} />
      ))}
    </div>
  );
}

export default EmployeesList;
