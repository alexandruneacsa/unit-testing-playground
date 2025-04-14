package com.testing.mockito.mocks.email;

import lombok.*;

import java.util.Iterator;
import java.util.regex.Pattern;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class RemoteMachineProxy {

    private final String remoteUrl;
    private Iterator<String> remoteFileIterator;

    private void connect() {

        System.out.println("Connecting...");
    }

    void setTestIterator(Iterator<String> testIterator) {

        this.remoteFileIterator = testIterator;
    }

    public String getNextFile() {

        if (remoteFileIterator.hasNext()) {

            var record = remoteFileIterator.next();

            var m = Pattern
                    .compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+")
                    .matcher(record);

            if (m.find())  {

                return m.group();
            }

            return remoteFileIterator.next();
        }

        return null;
    }
}
