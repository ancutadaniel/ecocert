import React from 'react';
import './App.css';

function App() {
  return (
    <div className="App">

      <form action="http://192.168.34.8:8081/images" method="post" encType="multipart/form-data">
        <input name="image" accept="image/*" type="file" />
        <input type="submit" value="Upload" name="submit" />
      </form>
    </div>
  );
}

export default App;
