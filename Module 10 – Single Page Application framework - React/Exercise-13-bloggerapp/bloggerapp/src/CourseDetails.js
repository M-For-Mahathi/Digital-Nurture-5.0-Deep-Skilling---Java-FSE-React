import React from "react";

function CourseDetails(props) {
  let seatsMessage;
  if (props.seatsLeft === 0) {
    seatsMessage = <p>No seats left</p>;
  } else {
    seatsMessage = <p>{props.seatsLeft} seats left</p>;
  }

  return (
    <div>
      {props.enrolled && <p>You are enrolled in this course</p>}
      {seatsMessage}
    </div>
  );
}

export default CourseDetails;
