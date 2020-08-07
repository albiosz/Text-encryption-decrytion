# Text-encryption-decrytion
## Quick description
Simple terminal program that allows user to decrypt and encrypt text using two variations of Caesar's cipher.
Each character in the plaintext is replaced by a character some fixed number of positions down the alphabet. <br/>
First one is called "Shift". It ciphers only letters from English alphabet. Rest of text remains unchanged. <br/>
Second one is called "Unicode". It ciphers all available characters in Unicode table.

## How to use
To compile use javac. The simplest way is to compile everything if you are in project directory: <br/>
`javac *.java`

To run compiled program use: <br/>
`java Main` (+ options)

## Available options:
* **-key** - number of position a letter will be shifted (default = 0) e.g. -key 5
* **-mode** - chose mode from two available: decrypt(dec) or encrypt(enc) (default = enc) e.g. -mode dec
* **-data** - use this option to pass text to process in command line (default = "") e.g. -data "Hello"
* **-in** - use this one to pass text in a file (file shoud be in folder "TextFiles") (default = "") e.g. -in file.txt
* **-out** - use this option if you want to return result to a file (default = "") e.g. -out outFile.txt
* **-alg** - select algorithm from two available: "unicode" or "shift" (default = "unicode") e.g. -alg shift

## Examples of usage
`java Main -mode enc -in toEncrypt.txt -out encrypted.txt -key 5 -alg unicode`
`java Main -key 5 -alg shift -data "Welcome!" -mode enc`
