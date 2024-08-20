import React from 'react';
import FaceUpload from './FaceUpload';
import FaceList from './FaceList';

function HomePage() {
  return (
    <div>
      <h1>Criminal Face Detection System</h1>
      <FaceUpload />
      <FaceList />
    </div>
  );
}

export default HomePage;
