import React from 'react';
import { Link } from 'react-router-dom'

import { ReactComponent as Logo } from '../../assets/logo.svg';

import './styles.css';

const Header = () => (
    <header className="main-header">
        <Link to="/">
            <Logo />
        </Link>
        <Link to="/">
            <div className="logo-text">
                <span className="logo-text-1">Big Game</span>
                <span className="logo-text-2"> Survey</span>
            </div>
        </Link>
    </header>
);

export default Header;

// PAREI NO MINUTO 37:23 DA AULA 2