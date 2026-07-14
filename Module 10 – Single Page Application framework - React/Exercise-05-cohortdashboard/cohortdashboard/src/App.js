import CohortDetails from "./CohortDetails";
import CohortData from "./Cohort";

function App() {
  return (
    <div>
      {CohortData.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
