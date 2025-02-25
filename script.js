document.addEventListener("DOMContentLoaded", () => {
    const events = [
        { name: "Tech Fest", date: "March 15, 2025", location: "XYZ College" },
        { name: "Cultural Night", date: "April 20, 2025", location: "ABC University" },
        { name: "Startup Meet", date: "May 5, 2025", location: "LMN Institute" }
    ];

    const eventList = document.getElementById("eventList");

    events.forEach(event => {
        const eventCard = document.createElement("div");
        eventCard.className = "event-card";
        eventCard.innerHTML = `
            <h3>${event.name}</h3>
            <p>${event.date} - ${event.location}</p>
        `;
        eventList.appendChild(eventCard);
    });
});
