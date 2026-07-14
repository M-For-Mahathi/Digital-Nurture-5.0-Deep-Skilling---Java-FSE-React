import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Home from "./Home";
import TrainersList from "./Trainerlist";
import TrainerDetail from "./TrainerDetails";
import TrainersMock from "./TrainersMock";

function App() {
  return (
    <BrowserRouter>
      <Link to="/">Home</Link> | <Link to="/trainers">Trainers</Link>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/trainers" element={<TrainersList trainers={TrainersMock} />} />
        <Route path="/trainers/:id" element={<TrainerDetail />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
