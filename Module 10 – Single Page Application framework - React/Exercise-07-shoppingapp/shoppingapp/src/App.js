import React, { Component } from "react";

class Cart {
  constructor(itemname, price) {
    this.Itemname = itemname;
    this.Price = price;
  }
}

class OnlineShopping extends Component {
  constructor(props) {
    super(props);
    this.items = [
      new Cart("Mouse", 599),
      new Cart("Keyboard", 2499),
      new Cart("USB Hub", 1299),
      new Cart("Laptop Stand", 899),
      new Cart("Webcam", 1999)
    ];
  }

  render() {
    return (
      <div>
        {this.items.map((item, index) => (
          <p key={index}>
            {item.Itemname} - {item.Price}
          </p>
        ))}
      </div>
    );
  }
}

function App() {
  return (
    <div>
      <OnlineShopping />
    </div>
  );
}

export default App;
