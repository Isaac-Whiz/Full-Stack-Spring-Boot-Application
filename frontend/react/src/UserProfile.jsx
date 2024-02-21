const UserProfile = ({name, age, stereotype, imageNumber, ...props}) => {
    stereotype = stereotype === "male" ? "men" : "women";
    return (
        <div>
            <h1>{name}</h1>
            <p>{age}</p>
            <img src={`https://randomuser.me/api/portraits/${stereotype}/${imageNumber}.jpg`} alt={"Pic"}/>
            {props.children}
        </div>
    );
}

export default UserProfile;