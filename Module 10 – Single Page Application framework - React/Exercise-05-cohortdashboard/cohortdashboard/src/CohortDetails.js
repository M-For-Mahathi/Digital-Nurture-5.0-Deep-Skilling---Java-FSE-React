import React from "react";
import styles from "./CohortDetails.module.css";

function CohortDetails(props) {
  const cohort = props.cohort;
  const color = cohort.status === "ongoing" ? "green" : "blue";

  return (
    <div className={styles.box}>
      <h3 style={{ color: color }}>{cohort.code}</h3>
      <dl>
        <dt>Status</dt>
        <dd>{cohort.status}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
