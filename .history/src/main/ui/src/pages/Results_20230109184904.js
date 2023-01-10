import Header from "../Header";

function Results() {
  const myData = localStorage["objectToPass"];
  localStorage.removeItem("objectToPass"); // Clear the localStorage
  console.log("Here is my wait_time: ", myData);
  return (
    <>
      <Header />
      <p>This is the Results page</p>
    </>
  );
}

export default Results;
