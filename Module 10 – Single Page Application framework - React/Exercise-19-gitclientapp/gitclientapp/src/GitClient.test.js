import axios from "axios";
import GitClient from "./GitClient";

jest.mock("axios");

describe("Git Client Tests", () => {
  test("should return repository names for techiesyed", () => {
    const mockData = {
      data: [
        { name: "repo-one" },
        { name: "repo-two" }
      ]
    };

    axios.get.mockResolvedValue(mockData);

    const gitClient = new GitClient();

    return gitClient.getRepositories("techiesyed").then((repositories) => {
      expect(repositories).toEqual(["repo-one", "repo-two"]);
    });
  });
});
