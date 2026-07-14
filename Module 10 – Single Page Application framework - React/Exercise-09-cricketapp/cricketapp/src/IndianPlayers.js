import React from "react";

const oddEvenTeam = {
  oddTeamPlayers: ["Rohit Sharma", "Virat Kohli", "KL Rahul"],
  evenTeamPlayers: ["Shubman Gill", "Rishabh Pant", "Axar Patel"]
};

const T20players = ["Rohit Sharma", "Virat Kohli", "Suryakumar Yadav"];
const RanjiTrophyplayers = ["Prithvi Shaw", "Sarfaraz Khan", "Yashasvi Jaiswal"];

function IndianPlayers() {
  const { oddTeamPlayers, evenTeamPlayers } = oddEvenTeam;
  const allPlayers = [...T20players, ...RanjiTrophyplayers];

  return (
    <div>
      <h2>Odd Team Players</h2>
      {oddTeamPlayers.map((name, index) => (
        <p key={index}>{name}</p>
      ))}

      <h2>Even Team Players</h2>
      {evenTeamPlayers.map((name, index) => (
        <p key={index}>{name}</p>
      ))}

      <h2>T20 + Ranji Trophy Players</h2>
      {allPlayers.map((name, index) => (
        <p key={index}>{name}</p>
      ))}
    </div>
  );
}

export default IndianPlayers;
