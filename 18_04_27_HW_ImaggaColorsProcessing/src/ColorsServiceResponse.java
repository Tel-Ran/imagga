
public class ColorsServiceResponse {
public ColorsResult[]results;
public UnsuccessfulMessage[] unsuccessful;
public ColorsResult[] getResults() {
	return results;
}
public UnsuccessfulMessage[] getUnsuccessful() {
	return unsuccessful;
}

}
