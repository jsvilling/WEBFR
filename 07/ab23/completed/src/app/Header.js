import React from "react";

const Header = ({ title, subtitle }) => (
    <div class="rounded px-3 px-sm-4 py-3 py-sm-5 bg-light">
        <h1 className="display-3">{title}</h1>
        <p className="lead">{subtitle}</p>
    </div>
);

export default Header;
