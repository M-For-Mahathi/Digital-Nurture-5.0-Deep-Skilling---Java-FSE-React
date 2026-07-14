import React from "react";
import { Link } from "react-router-dom";

function TrainersList(props) {
  return (
    <div>
      <ul>
        {props.trainers.map((trainer) => (
          <li key={trainer.TrainerId}>
            <Link to={"/trainers/" + trainer.TrainerId}>{trainer.Name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TrainersList;
