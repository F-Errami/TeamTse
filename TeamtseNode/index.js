const axios = require('axios');

const baseURL = 'http://localhost:8080'; 


const handleError = (error) => {
  console.error('Error:', error.response ? error.response.data : error.message);
};

// Function to test TeamController endpoints
const testTeamController = async () => {
  try {
    // Create a team with players
    const teamResponse = await axios.post(`${baseURL}/teams`, { name: 'Test Team', players: [{ name :'player 1'}, { name :'player 2'}] });
    const teamId = teamResponse.data.id;

    console.log('Team created:', teamResponse.data);

    // Get all teams
    const allTeamsResponse = await axios.get(`${baseURL}/teams`);
    console.log('All Teams:', allTeamsResponse.data);

    // Get one team by ID
    const oneTeamResponse = await axios.get(`${baseURL}/teams/${teamId}`);
    console.log('One Team:', oneTeamResponse.data);

    // Update a team
    const updateTeamResponse = await axios.put(`${baseURL}/teams/${teamId}`, { name: 'Updated Team' });
    console.log('Updated Team:', updateTeamResponse.data);

    // Delete a team
    await axios.delete(`${baseURL}/teams/${teamId}`);
    console.log('Team deleted successfully');
  } catch (error) {
    handleError(error);
  }
};

// Function to test PlayerController endpoints
const testPlayerController = async () => {
  try {
    // Create a player
    const playerResponse = await axios.post(`${baseURL}/players`, { name: 'Test Player' });
    const playerId = playerResponse.data.id;

    console.log('Player created:', playerResponse.data);

    // Get all players
    const allPlayersResponse = await axios.get(`${baseURL}/players`);
    console.log('All Players:', allPlayersResponse.data);

    // Get one player by ID
    const onePlayerResponse = await axios.get(`${baseURL}/players/${playerId}`);
    console.log('One Player:', onePlayerResponse.data);

    // Update a player
    const updatePlayerResponse = await axios.put(`${baseURL}/players/${playerId}`, { name: 'Updated Player' });
    console.log('Updated Player:', updatePlayerResponse.data);

    // Delete a player
    await axios.delete(`${baseURL}/players/${playerId}`);
    console.log('Player deleted successfully');
  } catch (error) {
    handleError(error);
  }
};

// Execute the test functions
testTeamController();
testPlayerController();
