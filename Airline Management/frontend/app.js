// Handle form submission for flight search
document.getElementById('searchForm').addEventListener('submit', function (event) {
    event.preventDefault();
    const pickup = document.getElementById('pickup').value;
    const destination = document.getElementById('destination').value;
    const departureDate = document.getElementById('departureDate').value;
    const returnDate = document.getElementById('returnDate').value;

    // Send AJAX request to search for flights
    fetch('searchFlights', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ pickup, destination, departureDate, returnDate })
    })
        .then(response => response.json())
        .then(data => {
            // Handle flight search results
            const resultsDiv = document.getElementById('flightResults');
            resultsDiv.innerHTML = '<h2>Available Flights</h2>';
            if (data.flights.length > 0) {
                const table = document.createElement('table');
                table.innerHTML = '<thead><tr><th>Flight Number</th><th>Departure Time</th><th>Arrival Time</th><th>Available Seats</th><th>Select</th></tr></thead><tbody>';
                data.flights.forEach(flight => {
                    const row = `<tr>
                    <td>${flight.flightNumber}</td>
                    <td>${flight.departureTime}</td>
                    <td>${flight.arrivalTime}</td>
                    <td>${flight.availableSeats}</td>
                    <td><button onclick="selectFlight('${flight.flightNumber}')">Select</button></td>
                </tr>`;
                    table.innerHTML += row;
                });
                table.innerHTML += '</tbody>';
                resultsDiv.appendChild(table);
            } else {
                resultsDiv.innerHTML += '<p>No flights available.</p>';
            }
        });
});

// Handle flight selection
function selectFlight(flightNumber) {
    // Store selected flight number and redirect to booking page
    localStorage.setItem('selectedFlightNumber', flightNumber);
    window.location.href = 'booking.html';
}

// Handle form submission for booking
document.getElementById('bookingForm')?.addEventListener('submit', function (event) {
    event.preventDefault();
    const flightNumber = document.getElementById('flightNumber').value;
    const seat = document.getElementById('seat').value;
    const passengerName = document.getElementById('passengerName').value;
    const payment = document.getElementById('payment').value;

    // Send AJAX request to complete the booking
    fetch('bookFlight', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ flightNumber, seat, passengerName, payment })
    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert('Booking confirmed!');
                window.location.href = 'search.html';
            } else {
                alert('Booking failed. Please try again.');
            }
        });
});
