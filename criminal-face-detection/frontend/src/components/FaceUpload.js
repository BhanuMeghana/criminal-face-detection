import React, { useState } from 'react';
import axios from 'axios';

function FaceUpload() {
  const [file, setFile] = useState(null);

  const onFileChange = (e) => {
    setFile(e.target.files[0]);
  };

  const onUpload = () => {
    const formData = new FormData();
    formData.append('file', file);
    axios.post('/api/faces/upload', formData)
      .then(response => alert(response.data))
      .catch(error => console.error('Error uploading file:', error));
  };

  return (
    <div>
      <input type="file" onChange={onFileChange} />
      <button onClick={onUpload}>Upload</button>
    </div>
  );
}

export default FaceUpload;
