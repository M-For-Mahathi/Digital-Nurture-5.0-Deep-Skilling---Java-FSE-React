import React from "react";

function BookDetails(props) {
  if (props.available) {
    return <p>Book is available</p>;
  } else {
    return <p>Book is out of stock</p>;
  }
}

export default BookDetails;
