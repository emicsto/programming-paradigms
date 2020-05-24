package optimazation_13.examples

class ExampleFactory {

    enum class ExampleId(val lp: Int, val title: String) {
        OPERATION_ORDER(1, "Kolejność funkcyjnych operacji na listach"),
        FINDING_ELEMENT(2, "Szukanie elementu w kolekcji"),
        PRIMITIVE_COLLECTION(3, "Operacje na kolekcji z liczbami prostymi"),
        MUTABLE_COLLECTION(4, "Porównanie operacji na niezmiennej kolekcji i zmiennej kolekcji")
    }

    private val examples = mapOf<ExampleId, (Int) -> Example>(
            ExampleId.OPERATION_ORDER to { size -> OperationOrderExample(size) },
            ExampleId.FINDING_ELEMENT to { size -> FindingElementExample(size) },
            ExampleId.PRIMITIVE_COLLECTION to { size -> PrimitiveCollectionExample(size) },
            ExampleId.MUTABLE_COLLECTION to { size -> MutableCollectionExample(size) }
    )

}