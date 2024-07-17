import Chart from 'chart.js/auto';

console.log('do_monitor.js loaded'); // 스크립트 로드 확인

document.addEventListener('DOMContentLoaded', async function () {
    try {
        const response = await fetch('api/data/do');
        console.log('Response: ', response);
        if (!response.ok) {
            throw new Error(`Network response was not ok: ${response.statusText}`);
        }
        const data = await response.json();
        console.log('Data: ', data);

        if (data.length === 0) {
            console.error('No data available');
            return;
        }

        const labels = data.map(point => point.date);
        const values = data.map(point => point.value);

        console.log('Labels: ', labels);
        console.log('Values: ', values);

        const ctx = document.getElementById('myDoChart').getContext('2d');
        const myDoChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: labels,
                datasets: [{
                    label: 'DO Measurement',
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
                },
                responsive: true,
                maintainAspectRatio: false
            }
        });
    } catch (error) {
        console.error('Error fetching data: ', error);
        alert('Error fetching data, please check the console for more information.');
    }
});
