import React from 'react';

const UserContext = React.createContext({
    user: {},
    handleUserChange: () => {}
});

export default UserContext;