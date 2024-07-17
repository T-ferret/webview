import Chart from "chart.js/auto";

console.log('waterTemp_monitor.js loaded'); // Log to confirm script is loaded

document.addEventListener('DOMContentLoaded', function () {
    fetch('api/data/waterTemp')
        .then(response => {
            console.log('Response: ', response);
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            console.log('Data: ', data);

            if (data.length === 0) {
                console.error('No data available');
                return;
            }

            const labels = data.map(point => point.date);
            const values = data.map(point => point.value);

            console.log('Labels: ', labels);
            console.log('Values: ', values)

            const ctx = document.getElementById('myWaterTempChart').getContext('2d');
            const myWaterTempChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: labels,
                    datasets: [{
                        label: 'waterTemp Dataset',
                        data: values,
                        borderColor: 'rgba(75, 192, 192, 1)',
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        })
        .catch(error => console.error('Error fetching data: ', error));
});