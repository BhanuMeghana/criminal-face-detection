import React, { useEffect, useState } from 'react';
import axios from 'axios';

function FaceList() {
  const [faces, setFaces] = useState([]);

  useEffect(() => {
    axios.get('/api/faces')
      .then(response => setFaces(response.data))
      .catch(error => console.error('Error fetching faces:', error));
  }, []);

  return (
    <div>
      <h2>Detected Faces</h2>
      <ul>
        {faces.map(face => (
          <li key={face.id}>
            <img src={face.imageUrl} alt="Detected Face" />
            <p>{face.detectedFaces}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default FaceList;
