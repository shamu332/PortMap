import Header from "../Header";

function Results() {
  var data = localStorage.getItem("results");
  localStorage.clear(); //clean the localstorage
  var value1 = JSON.parse(data).wait_time;
  console.log("Here is my wait_time: ", value1);
  return (
    <>
      <Header />
      <p>This is the Results page</p>
    </>
  );
}

export default Results;
