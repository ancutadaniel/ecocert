import React from 'react';
import './App.css';

import "bootstrap/dist/css/bootstrap.min.css";
import { HomePage, Formular, AddImage } from './pages/';
import { BrowserRouter, Route} from 'react-router-dom';
import { Container } from 'react-bootstrap';

import "bootstrap/dist/css/bootstrap.min.css";
import MainMenu from './shared/mainMenu';
import { library } from '@fortawesome/fontawesome-svg-core';
import { faCheckSquare, fas } from '@fortawesome/free-solid-svg-icons';

library.add(fas, faCheckSquare,);


class App extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <BrowserRouter>
                    <Container className="App main">
                      <MainMenu site_name="ECOCERT"/>
                      <Route exact path="/" component={ HomePage } />
                      <Route exact path="/formular" component={ Formular } />
                      <Route exact path="/addimage" component={ AddImage } />
                    </Container>
            </BrowserRouter>
        );
    }
}

export default App;
