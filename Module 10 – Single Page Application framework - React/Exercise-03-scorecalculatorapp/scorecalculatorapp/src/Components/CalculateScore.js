import React from "react";
import "../Stylesheets/mystyle.css";

function CalculateScore(props) {
  const average = props.total / props.goal;

  return (
    <div className="score">
      <h2>Score Calculator</h2>
      <p>Name: {props.name}</p>
      <p>School: {props.school}</p>
      <p>Total: {props.total}</p>
      <p>Goal: {props.goal}</p>
      <p>Average: {average}</p>
    </div>
  );
}

export default CalculateScore;
