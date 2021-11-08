
function Header({title, subtitle}) {
    return (
        <div class="rounded px-3 px-sm-4 py-3 py-sm-5 bg-light">
            <h1 className="display-3">{title}</h1>
            <h3 className="lead">{subtitle}</h3>
        </div>
    );
}

export default Header;
