import React from "react";

function BlogDetails(props) {
  return (
    <div>
      {props.published ? <p>Blog is published</p> : <p>Blog is in draft</p>}
    </div>
  );
}

export default BlogDetails;
