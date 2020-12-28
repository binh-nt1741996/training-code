#include<iostream>
#include<string>
#include<sstream>

using namespace std;
class Solution {
public:
    string* splitIP(string IP, string delimiter){
        size_t pos = 0;
        string token;
        string* IPList = new string[4];
        int count = 0;
        while ((pos = IP.find(delimiter)) != std::string::npos){
            token = IP.substr(0, pos);
            *(IPList + count) = token;
            IP.erase(0, pos + 1);
            count++;
        }
        *(IPList + count) = IP;
        cout << count << endl;
        return IPList;
    }
    bool firstDigit(string& subIP){
        if (subIP.size() == 1){
            return false;
        } else{
            return subIP[0] == '0';
        }
    }
    bool validIPv4(const string& subIP){
        int IP = std::stoi(subIP);
        return IP < 0 | IP > 255;
    }
    string validIPAddress(string IP) {
        string result = "";
        if (IP.length() > 13){
            string* IPList = splitIP(IP, ":");
            return "";
        } else{
            string* IPList = splitIP(IP, ".");
            for (auto i {0}; i < 4; i++){
                if (firstDigit(*(IPList + i)) | validIPv4(*(IPList + i))){
                    return "Neither";
                }
            }
            return "IPv4";
        }
    }
};

int main(int argc, char const *argv[])
{
    Solution* sol = new Solution();
    cout << sol->validIPAddress("192.168.1.0") << endl;
    return 0;
}
