function func1() {
  try {
    throw new Error('Error occurred in func1');
  } catch (err) {
    console.error(err); // Error: Error occurred in func1
    throw err;
  }
}

function func2() {
  try {
    func1();
  } catch (err) {
    console.error(err); // 이 부분은 실행되지 않음
  }
}

try {
  func2();
} catch (err) {
  console.error(err); // 이 부분은 실행되지 않음
}
