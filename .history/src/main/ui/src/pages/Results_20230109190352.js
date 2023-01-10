import Header from "../Header";

function Results() {
  const data = localStorage.getItem("results");
  localStorage.clear(); //clean the localstorage
  const waitTime = JSON.parse(data).wait_time;
  const ipAddress = JSON.parse(data).ip_address;
  const openedPorts = JSON.parse(data).ports_opened;

  const statement = `Scanning of IP: ${ipAddress} took ${waitTime} seconds`;
  return (
    <>
      <Header />
      <p style={{ textAlign: "center", fontSize: "140%" }}>{statement}</p>
    </>
  );
}

export default Results;
