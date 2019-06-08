import React from 'react';
import './App.css';
import { FilePond, registerPlugin } from 'react-filepond';
import 'filepond/dist/filepond.min.css';

import FilePondPluginImagePreview from 'filepond-plugin-image-preview';
import 'filepond-plugin-image-preview/dist/filepond-plugin-image-preview.min.css';

import FilePondPluginFileValidateType from 'filepond-plugin-file-validate-type';

// Register the plugin
registerPlugin(FilePondPluginImagePreview);
registerPlugin(FilePondPluginFileValidateType);

class App extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            server: {
                process: 'http://192.168.34.67:8081/images',
                fetch: null,
                revert: null,
                restore: null,
                load: null
            },
            acceptedFileTypes: ['image/*']
        };

    }
    render() {
        return (
            <div className="App">
                  <FilePond allowMultiple={true} server={this.state.server} acceptedFileTypes={this.state.acceptedFileTypes} />
            </div>
        );
    }
}
export default App;
