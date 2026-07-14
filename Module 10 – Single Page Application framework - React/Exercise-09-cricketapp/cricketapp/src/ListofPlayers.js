import React from "react";

const players = [
  { name: "Rohit Sharma", score: 85 },
  { name: "Virat Kohli", score: 45 },
  { name: "KL Rahul", score: 62 },
  { name: "Suryakumar Yadav", score: 30 },
  { name: "Hardik Pandya", score: 55 },
  { name: "Ravindra Jadeja", score: 25 },
  { name: "Jasprit Bumrah", score: 5 },
  { name: "Mohammed Shami", score: 8 },
  { name: "Shubman Gill", score: 90 },
  { name: "Rishabh Pant", score: 40 },
  { name: "Axar Patel", score: 20 }
];

function ListofPlayers() {
  const lowScorers = players.filter((player) => player.score < 70);

  return (
    <div>
      <h2>List of Players</h2>
      {players.map((player, index) => (
        <p key={index}>{player.name} - {player.score}</p>
      ))}

      <h2>Players below 70</h2>
      {lowScorers.map((player, index) => (
        <p key={index}>{player.name} - {player.score}</p>
      ))}
    </div>
  );
}

export default ListofPlayers;
