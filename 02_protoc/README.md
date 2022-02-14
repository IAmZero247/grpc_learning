# ProtoC

1. IDL(Interface Description Languauge) for API
1. Platform and language neutral
1. Ser-De for sturutred data
1. Very fast and optimised for Inter Service Communication
1. Provide client side lib for java js c++ python ruby go php etc.

# ProtoField Numbers 
1. Each field is assigned with unique number
1. 1-15 (for frequently used fields) 1 byte
1. 16-2047  2 byte
1. 1 is smallest and (2^29) -1 is largest
1. 19000 to 19999 is reserved
1. Dont change field number once it is in use
1. Adding new fields wont break old proto
1. Removing filed wont break old proto (use reserved for field number in case if you remove)
1. Renaming is okea, but be cautious
1. Keep proto as seperate maven modules and add them as dependency in other module
1. Changing type: 
      - int32- int64 is okea
      - int64 - int32 might create problem

# Data Types

## ps- import "google/protobuf/wrappers.proto";

| Java Type   | Proto Type  | Wrappers        | Default Value|
|    :---:    |   :----:    |      :---:      |     :---:    |
|int            |int32       |google.protobuf.Int32Value |0 |
|long           |int64       |google.protobuf.Int64Value |0 |
|float          |float       |google.protobuf.Float4Value|0 | 
|double         |double      |google.protobuf.DoubeValue |0 |
|boolean        |bool        |google.protobuf.BoolValue  |false|
|String         |string      |google.protobuf.StringValue|empty string|
|byte[]         |bytes       |google.protobuf.BytesValue  |  |
|Collection/List|repeated   || empty list|
|Map            |map        || wrapper/empty map|
|enum           |           || first value|
