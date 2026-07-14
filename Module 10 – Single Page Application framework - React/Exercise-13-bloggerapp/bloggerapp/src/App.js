import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function App() {
  return (
    <div>
      <BookDetails available={true} />
      <BlogDetails published={false} />
      <CourseDetails enrolled={true} seatsLeft={3} />
    </div>
  );
}

export default App;
