import React from "react";
import { useParams } from "react-router-dom";
import TrainersMock from "./TrainersMock";

function TrainerDetail() {
  const { id } = useParams();
  const trainer = TrainersMock.find((t) => t.TrainerId === parseInt(id));

  return (
    <div>
      <h2>{trainer.Name}</h2>
      <p>Email: {trainer.Email}</p>
      <p>Phone: {trainer.Phone}</p>
      <p>Technology: {trainer.Technology}</p>
      <p>Skills: {trainer.Skills}</p>
    </div>
  );
}

export default TrainerDetail;
