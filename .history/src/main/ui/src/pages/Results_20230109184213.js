import Header from "../Header";

function Results(data) {
  console.log("Here is my wait_time: ", data);
  return (
    <>
      <Header />
      <p>This is the Results page</p>
    </>
  );
}

export default Results;