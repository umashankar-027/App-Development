import { useState } from 'react';
import './App.css';

function App() {
  const [name,setName] = useState('')
  const [sub,setSub] = useState(false)
  return (
    <div className="App">
      <header className="App-header">
      <input className='inp' val = {name} type='text' placeholder='Name' onChange={(x)=>setName(x.target.value)}/>
      <input className='inp' type='password' placeholder='Password'/>
      <button className='btn' onClick={()=>{setSub(true)}}>Submit</button>
      {sub &&( <p>{name}</p>)}
      </header>
    </div>
  );
}

export default App;
