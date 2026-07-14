const office = {
  name: "Skyline Business Center",
  rent: 75000,
  address: "Hitech City, Hyderabad"
};

const officeList = [
  { name: "Skyline Business Center", rent: 75000, address: "Hitech City, Hyderabad" },
  { name: "Cyber Towers", rent: 55000, address: "Madhapur, Hyderabad" },
  { name: "Green Valley Offices", rent: 40000, address: "Gachibowli, Hyderabad" }
];

function App() {
  const heading = <h1>Office Space Rental</h1>;

  return (
    <div>
      {heading}

      <img src="https://via.placeholder.com/300x150" alt="office space" />

      <p>Name: {office.name}</p>
      <p>Address: {office.address}</p>
      <p style={{ color: office.rent < 60000 ? "red" : "green" }}>
        Rent: {office.rent}
      </p>

      {officeList.map((item, index) => (
        <p key={index} style={{ color: item.rent < 60000 ? "red" : "green" }}>
          {item.name} - {item.address} - {item.rent}
        </p>
      ))}
    </div>
  );
}

export default App;
